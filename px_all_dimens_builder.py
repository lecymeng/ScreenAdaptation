#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import os
from xml.dom.minidom import parse
import xml.dom.minidom

basePx = [1280, 720]
dimenTypes = {800: 480, 960: 540, 1920: 1080, 2280: 1080, 2560: 1440, 2960: 1440}

moduleName = 'widthHeightQualifier'
rootPath = os.path.abspath('')
resPath = rootPath + '/' + moduleName + '/src/main/res'


def write_xml_data(height, width, dimen_data):
    xmlData = '<?xml version="1.0" encoding="utf-8"?>\n<resources>'
    for key, value in dimen_data.items():
        temp = int(value.replace('px', ''))
        if 'x' in key:
            dimenValue = '%.4f' % (temp * width / basePx[1])
        else:
            dimenValue = '%.4f' % (temp * height / basePx[0])
        row = '\n    <dimen name="%s">%spx</dimen>' % (key, dimenValue)
        xmlData = xmlData + row
    xmlData = xmlData + '\n</resources>'

    xmlPath = resPath + '/values-%1dx%2d' % (height, width)
    isExists = os.path.exists(xmlPath)
    if not isExists:
        os.makedirs(xmlPath)

    file = open(xmlPath + '/dimens.xml', "w")
    file.write(xmlData)
    file.close()


def generate_default_dimens():
    xmlData = '<?xml version="1.0" encoding="utf-8"?>\n<resources>'

    dimenXValue = 1
    while dimenXValue <= basePx[1]:
        row = '\n    <dimen name="%s">%spx</dimen>' % ('x%d' % dimenXValue, dimenXValue)
        xmlData = xmlData + row
        dimenXValue = dimenXValue + 1
    dimenYValue = 1
    while dimenYValue <= basePx[0]:
        row = '\n    <dimen name="%s">%spx</dimen>' % ('y%d' % dimenYValue, dimenYValue)
        xmlData = xmlData + row
        dimenYValue = dimenYValue + 1
    xmlData = xmlData + '\n</resources>'

    xmlPath = resPath + '/values'
    isExists = os.path.exists(xmlPath)
    if not isExists:
        os.makedirs(xmlPath)

    file = open(xmlPath + '/dimens.xml', "w")
    file.write(xmlData)
    file.close()

    print('generate default dimens finished')


if __name__ == '__main__':
    generate_default_dimens()

    root = xml.dom.minidom.parse(resPath + '/values/dimens.xml').documentElement
    dimens = root.getElementsByTagName('dimen')

    dimenData = {}
    for dimen in dimens:
        dimenData[dimen.getAttribute('name')] = dimen.firstChild.data

    for height, width in dimenTypes.items():
        write_xml_data(height, width, dimenData)
