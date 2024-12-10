import re


def convertation():

    xml_lines = ['<?xml version="1.0" encoding="UTF-8" ?>\n']

    with open('schedule_dop2.json', 'r', encoding='utf-8') as json:

        json_lines = json.readlines()
        xml_lines.append(f'<{re.sub(r'\s', '', re.sub('"', '', re.split(':', json_lines[1])[0]))}>\n')

        for i in range(len(json_lines)):

            json_lines[i] = re.sub(r'\n', '', json_lines[i])
            json_lines[i] = re.sub(r'\t', '    ', json_lines[i])

        tab_sdvig_list = 0
        opened_tags_tabs = []
        opened_tags = []
        opened_list = []
        opened_list_tags = []

        for i in range(2, len(json_lines) - 1):

            tab = json_lines[i].count('    ') - 1
            if re.search(r'\[', json_lines[i - 1]):
                tab_sdvig_list += 1
            elif re.search(r']', json_lines[i - 1]):
                tab_sdvig_list -= 1
            tab -= tab_sdvig_list

            if len(re.findall('"', json_lines[i])) == 4:
                tag, text = re.split(': ', re.sub(r'\s{2,}', '', json_lines[i]))
                tag = tag[tag.index('"') + 1: tag.rindex('"')]
                text = text[text.index('"') + 1: text.rindex('"')]
                xml_lines.append(f'{'    ' * tab}<{tag}>{text}</{tag}>\n')

            elif len(re.findall('"', json_lines[i])) == 2:
                tag, beg_list = re.split(': ', re.sub(r'\s{2,}', '', json_lines[i]))
                tag = tag[tag.index('"') + 1: tag.rindex('"')]

                if beg_list == '[':
                    opened_list.append(f'{'    ' * tab}[')
                    opened_list_tags.append(tag)
                    continue

                opened_tags_tabs.append(f'{'    ' * tab}{'{'}')
                opened_tags.append(tag)
                xml_lines.append(f'{'    ' * tab}<{tag}>\n')

            elif (opened_list != []) and (len(re.findall(r'\s', opened_list[-1])) // 4 == tab) and re.search('{', json_lines[i]):
                xml_lines.append(f'{'    ' * tab}<{opened_list_tags[-1]}>\n')

            elif re.search(r']', json_lines[i]):
                xml_lines.append(f'{'    ' * (tab + 1)}</{opened_list_tags[-1]}>\n')
                del opened_list[-1]
                del opened_list_tags[-1]

            elif re.search('},', json_lines[i]) and (len(re.findall(r'\s', opened_list[-1])) // 4 == tab):
                xml_lines.append(f'{'    ' * tab}</{opened_list_tags[-1]}>\n')

            elif (opened_tags_tabs != []) and re.search('}', json_lines[i]) and (len(re.findall(r'\s', opened_tags_tabs[-1])) // 4 == tab):
                xml_lines.append(f'{'    ' * tab}</{opened_tags[-1]}>\n')
                del opened_tags_tabs[-1]
                del opened_tags[-1]
        xml_lines.append(f'</{re.sub(r'\s', '', re.sub('"', '', re.split(':', json_lines[1])[0]))}>')

    with open('schedule_dop2.xml', 'w', encoding='utf-8') as xml:
        for line in xml_lines:
            xml.write(line)


convertation()
