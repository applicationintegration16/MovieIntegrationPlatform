from urllib.request import urlopen
from time import sleep

import requests
from json_util import JsonUtil
import json


def get_top_film():
    '''https://douban.uieee.com/'''
    url = 'https://douban.uieee.com/v2/movie/top250'
    movie_list_str = ''
    for start in range(0, 250, 50):
        req = requests.get(url, params={'start': start, 'count': 50})
        data = req.json()
        print(data)
        for movie in data['subjects']:
            print(movie)
            movie_str = json.dumps(movie)
            movie_list_str += movie_str + '\n'

        JsonUtil.write_file('src/main/resources/dataset/douban.json', movie_list_str)

        sleep(0.3)



get_top_film()