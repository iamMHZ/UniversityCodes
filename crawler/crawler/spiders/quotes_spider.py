import scrapy


class QuotesSpider(scrapy.Spider):
    name = "quotes"

    def start_requests(self):
        urls = [
            'http://quotes.toscrape.com/page/1/',
            'http://quotes.toscrape.com/page/2/',
        ]
        for url in urls:
            yield scrapy.Request(url=url, callback=self.parse)

    def parse(self, response):
        # saving html files :
        # page = response.url.split("/")[-2]
        # filename = 'quotes-%s.html' % page
        # with open(filename, 'wb') as f:
        #     f.write(response.body)
        # self.log('Saved file %s' % filename)

        print('\n\n')
        # printing quotes with css:
        titles = response.css('title::text').getall()
        for title in titles:
            print('[TITLE] : '+ title)

        # print quots :
        quotes_body = response.css('.quote > .text::text').extract()
        for quote in quotes_body:
            print('\n[QUOTE] : \n' + quote)