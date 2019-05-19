import codecs
import json

class JsonUtil:
    @staticmethod
    def write_file(file_name, data):
        file = open(file_name, 'w')
        file.write(data)
        file.close()


    @staticmethod
    def load_obj(file_path):
        obj_dict = []
        with codecs.open(file_path, 'r', 'utf8') as f:
            for line in f:
                obj = json.loads(line)
                obj_dict.append(obj)

        for obj in obj_dict:
            print(obj)
        print(len(obj_dict))



JsonUtil.load_obj('1.json')
