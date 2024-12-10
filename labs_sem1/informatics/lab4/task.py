# вариант 6


def convertation():

    xml_lines = ['<?xml version="1.0" encoding="UTF-8" ?>\n']

    with (open('schedule.json', 'r', encoding='utf-8') as json):

        json_lines = json.readlines()
        xml_lines.append(f'<{json_lines[1].split(':')[0].replace('"', '').lstrip()}>\n')

        for i in range(len(json_lines)):

            if '\n' in json_lines[i]:
                json_lines[i] = json_lines[i].replace('\n', '')
            if '\t' in json_lines[i]:
                json_lines[i] = json_lines[i].replace('\t', '    ')

        tab_sdvig_list = 0
        opened_tags_tabs = []
        opened_tags = []
        opened_list = []
        opened_list_tags = []

        for i in range(2, len(json_lines) - 1):

            tab = json_lines[i].count('    ') - 1
            if json_lines[i - 1][-1] == '[':
                tab_sdvig_list += 1
            elif json_lines[i - 1][-1] == ']':
                tab_sdvig_list -= 1
            tab -= tab_sdvig_list

            if json_lines[i].count('"') == 4:
                tag, text = json_lines[i].lstrip().split(': ')
                tag = tag[tag.index('"') + 1: tag.rindex('"')]
                text = text[text.index('"') + 1: text.rindex('"')]
                xml_lines.append(f'{'    ' * tab}<{tag}>{text}</{tag}>\n')

            elif json_lines[i].count('"') == 2:
                tag, beg_list = json_lines[i].lstrip().split(': ')
                tag = tag[tag.index('"') + 1: tag.rindex('"')]

                if beg_list == '[':
                    opened_list.append(f'{'    ' * tab}[')
                    opened_list_tags.append(tag)
                    continue

                opened_tags_tabs.append(f'{'    ' * tab}{'{'}')
                opened_tags.append(tag)
                xml_lines.append(f'{'    ' * tab}<{tag}>\n')

            elif (opened_list != []) and (opened_list[-1].count('    ') == tab) and json_lines[i][-1] == '{':
                xml_lines.append(f'{'    ' * tab}<{opened_list_tags[-1]}>\n')

            elif json_lines[i][-1] == ']':
                xml_lines.append(f'{'    ' * (tab + 1)}</{opened_list_tags[-1]}>\n')
                del opened_list[-1]
                del opened_list_tags[-1]

            elif json_lines[i][-2] == '}' and (opened_list[-1].count('    ') == tab):
                xml_lines.append(f'{'    ' * tab}</{opened_list_tags[-1]}>\n')

            elif (opened_tags_tabs != []) and json_lines[i].rstrip(',')[-1] == '}' and (opened_tags_tabs[-1].count('    ') == tab):
                xml_lines.append(f'{'    ' * tab}</{opened_tags[-1]}>\n')
                del opened_tags_tabs[-1]
                del opened_tags[-1]
        xml_lines.append(f'</{json_lines[1].split(':')[0].replace('"', '').lstrip()}>')

    with open('schedule.xml', 'w', encoding='utf-8') as xml:
        for line in xml_lines:
            xml.write(line)


convertation()
