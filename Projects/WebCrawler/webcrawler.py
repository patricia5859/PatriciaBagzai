__author__ = 'root'
import requests
from bs4 import BeautifulSoup
import time
import re
import argparse

parser = argparse.ArgumentParser(description='WebCrawler')
parser.add_argument('--url', dest='url', action='store', default="http://en.wikipedia.org/wiki/Hugh_of_Saint-Cher",help='URL')
parser.add_argument('--kw', dest='kw', action='store',default="",  help='Keyword')


args = parser.parse_args()


## global variables
gv_seed = args.url
gv_keyword=args.kw
gv_base_url = "http://en.wikipedia.org"
gv_count = 0
gv_depth = 1
gv_dict = {'http://en.wikipedia.org/wiki/Main_Page': 1}
gv_unique_url_list = []
gv_final_list=[]
f=open("output.txt","w")


class CrawlNode(object):
    def __init__(self, url, depth):
        self.depth = depth
        self.url = url


def get_href(url_obj, keyword):
    """
    :Function returns all valid anchor on the given url
    :param url_obj: CrawlNode
    :param keyword: String
    :return: List
    """
    lv_response = requests.get(url_obj.url)
    time.sleep(1)
    lv_depth = url_obj.depth + 1
    lv_soup = BeautifulSoup(lv_response.content, 'lxml')
    lv_url_list = []
    if (lv_soup.find_all(text=re.compile(keyword,re.IGNORECASE),limit=1)):
        gv_final_list.append(url_obj)
        print (url_obj.url)
        with open("output.txt","a+") as file:
            f.write(url_obj.url+"\n")


        for link in lv_soup.find_all('a'):
            lv_rel_url=str(link.get('href'))
            if "#" in lv_rel_url:
                lv_clean_url=lv_rel_url.split("#",1)[0]
            else:
                lv_clean_url=lv_rel_url


            if "/wiki/" == lv_clean_url[:6] and ":" not in lv_clean_url:
                lv_final_url = gv_base_url + lv_clean_url
                if lv_final_url in gv_dict.keys():
                    continue
                else:
                    lv_url_list.append(CrawlNode(lv_final_url, lv_depth))
                    gv_dict[lv_final_url] = 1
            else:
                    continue

    return lv_url_list


def main(url, keyword):
    """
    :Function: Maintains a list of unique URLS
    :param url: String
    :param keyword: String
    :return:void
    """


    gv_unique_url_list.append(CrawlNode(url, 1))
    lv_count = 0
    for temp_url in gv_unique_url_list:

        if len(gv_final_list) > 999 or temp_url.depth > 5:
            break
        else:
            gv_unique_url_list.extend(get_href(temp_url, keyword))
            lv_count += 1



if __name__ == "__main__":
    main(gv_seed, gv_keyword)
