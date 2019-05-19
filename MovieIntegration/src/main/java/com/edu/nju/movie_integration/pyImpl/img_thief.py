import requests
import os
from bs4 import BeautifulSoup

from sys import argv


def get_douban_img(url):
        url_t = url.split('"')[1]
        print(url_t)
        res = requests.get(url_t)
       # res = requests.get("https://movie.douban.com/subject/1292052/")
        print('*****1')
        soup = BeautifulSoup(res.text, 'html.parser')
        print('*****2')
        print(soup.select('img')[0])
        pic_str_list = str(soup.select('img')[0]).split('src="')[1].split('" title')
        print('-----')
        print(pic_str_list[0])
        file = open('src/main/resources/dataset/tmp.txt', 'a+')
        file.write(pic_str_list[0])
        file.write('\n')
        file.close()


get_douban_img(argv[1])