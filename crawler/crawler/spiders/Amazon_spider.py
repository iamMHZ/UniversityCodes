import scrapy
from scrapy.spiders import CrawlSpider, Rule
from scrapy.linkextractors import LinkExtractor


class AmazonCrawler(CrawlSpider):
    name = 'amazon_crawler'

    start_urls = [
        'https://www.amazon.com/b/ref=s9_acss_bw_cg_KOTHLPCG_1a1_w?node=565108&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-6&pf_rd_r=0RKF7FVNP517GE39J5QA&pf_rd_t=101&pf_rd_p=1e1598d2-28c3-4a64-91af-254d7a033ada&pf_rd_i=541966']

    rules = (Rule(LinkExtractor(), callback='parser'),)

    def parser(self, response):
        names = response.css('.a-size-large::text').extract()
        prices = response.css('.a-price-whole::text').extract()

        # for price in prices:
        #     print('\nPRICE : ' + str(price))
        #     with open('AmazonPrices.txt' ,'a') as f  :
        #         f.write( str(price) +'\n')

        for name in names:
            print('\nNMAE: ' + name + '\n')
            with open('Amazon_Laptops.txt', 'a') as f:
                f.write(name + '\n')
