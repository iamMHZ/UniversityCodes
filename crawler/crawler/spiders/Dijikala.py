from scrapy.spiders import CrawlSpider, Rule
from scrapy.linkextractors import LinkExtractor


class AmazonCrawler(CrawlSpider):
    name = 'digi'

    start_urls = ['https://www.digikala.com/search/category-notebook-netbook-ultrabook/?pageno=1&sortby=4']

    rules = (Rule(LinkExtractor(), callback='parser'),)

    def parser(self, response):
        names = response.css('.c-price__value-wrapper::text').extract()
        # prices = response.css('.a-price-whole::text').extract()

        # for price in prices:
        #     print('\nPRICE : ' + str(price))
        #     with open('DigikalaPrices.txt' ,'a') as f  :
        #         f.write( str(price) +'\n')

        for name in names:
            print('\nNMAE: ' + name + '\n')
            with open('DigikalaLaptops.txt', 'a') as f:
                f.write(name + '\n')
