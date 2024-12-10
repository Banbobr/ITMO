from json2xml import json2xml
from json2xml.utils import readfromjson


def convertation():

    json = readfromjson('schedule_dop1.json')

    with open('schedule_dop1.xml', 'w', encoding='utf-8') as xml_file:
        xml_file.write(json2xml.Json2xml(json, root=False, attr_type=False, item_wrap=False).to_xml())


convertation()
