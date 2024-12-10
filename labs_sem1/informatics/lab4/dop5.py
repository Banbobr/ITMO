from json2xml.utils import readfromjson

json_dict = readfromjson('schedule_dop5.json')
csv_lines = ['day;title;type;teacher;building;classroom;beginning;end\n']

for i in range(len(json_dict['schedule']['day'])):
    for j in range(len(json_dict['schedule']['day'][i][list(json_dict['schedule']['day'][i].keys())[0]]['pair'])):
        line = []
        line.append(list(json_dict['schedule']['day'][i].keys())[0])
        pair = json_dict['schedule']['day'][i][list(json_dict['schedule']['day'][i].keys())[0]]['pair'][j]
        line.append(pair['title'])
        line.append(pair['type'])
        line.append(pair['teacher'])
        line.append(pair['adress']['building'])
        line.append(pair['adress']['classroom'])
        line.append(pair['time']['beginning'])
        line.append(pair['time']['end'])
        csv_lines.append(f'{';'.join(line)}\n')

with open('schedule_dop5.csv', 'w') as csv_file:
    for line in csv_lines:
        csv_file.write(line)
