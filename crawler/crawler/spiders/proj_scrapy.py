import scrapy


class Proj_Spider(scrapy.Spider):
    name = "sokhanha"
    start_urls = [
        'http://sokhanha.ir/'
    ]

    def parse(self, response):
        for quote in response.css('article'):
            yield {
                'title': quote.css('h1.entry-title a::text').get(),

                'body': quote.css('div.entry-content p::text').getall()
            }
