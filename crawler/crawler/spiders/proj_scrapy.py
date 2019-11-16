import scrapy
import csv


class Proj_Spider(scrapy.Spider):
    name = "sokhanha"

    def __init__(self):
        self.counter = 0
        self.depth = 5

    def start_requests(self):
        urls = [
            'http://sokhanha.ir/'
        ]

        for url in urls:
            if self.counter < self.depth:
                yield scrapy.Request(url=url, callback=self.parse)

    def parse(self, response):
        self.counter += 1

        self.log("  COUNTER : " + str(self.counter))

        inner_urls = response.css('.page-numbers::attr(href)')

        for url in inner_urls:
            # print("\nURL:" + str(url))
            url = str(url).split('=')[2][:-1]
            # print("\nURL 2 :" + str(url))

            url = f'{url[1:-1]}'

            response.urljoin(url)
            if self.counter < self.depth:
                yield scrapy.Request(url, callback=self.parse)

        for quote in response.css('article'):
            yield {'title': quote.css('h1.entry-title a::text').get(),
                   'content': quote.css('div.entry-content p::text').getall()}

            # title = quote.css('h1.entry-title a::text').get()
            # content = quote.css('div.entry-content p::text').getall()
            # fields = ['عنوان', 'متنن']
            # rows = [title, content]
            # with open('sokhnha.txt', 'a') as f:
            #     # f.write("TITLE : " + str(title) + "\nCONTENT: " + str(content) + '\n')
            #     csvwriter = csv.writer(f)
            #     csvwriter.writerow(rows)
