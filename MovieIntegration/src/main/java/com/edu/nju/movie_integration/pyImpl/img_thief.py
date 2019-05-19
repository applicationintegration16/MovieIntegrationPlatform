import requests
import urllib
from bs4 import BeautifulSoup

class ImgThief:
    @staticmethod
    def get_douban_img(url):
        res = requests.get(url)
        soup = BeautifulSoup(res.text, 'html.parser')
        # print(soup.select('img')[0])
        return soup.select('img')[0]


ImgThief.get_douban_img('https://movie.douban.com/subject/1295644/')