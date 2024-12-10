# вариант: 4
import re

# pattern = (r'(?:(?:[0-5]\d)|\*)\ '
#            r'(?:(?:(?:1\d)|(?:2[0-3])|(?:\d))|\*)\ '
#            r'(?:(?:(?:1\d)|(?:[1-9])|(?:2\d)|(?:3[0-1]))|\*)\ '
#            r'(?:(?:(?:1[0-2])|(?:[1-9])|jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)|\*)\ '
#            r'(?:(?:(?:[0-6])|sun|mon|tue|wed|thu|fri|sat)|\*)')
pattern = (r'(?:(?:(?:[0-5]\d-?)*|[0-5]\d)|\*) '
           r'(?:(?:(?:1\d|2[0-3]|\d-*)*|1\d|2[0-3]|\d)|\*) '
           r'(?:(?:(?:1\d|[1-9]|2\d|3[0-1]-*)*|1\d|[1-9]|2\d|3[0-1])|\*) '
           r'(?:(?:(?:1[0-2])|(?:[1-9])|jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)|\*)\ '
           r'(?:(?:(?:[0-6])|sun|mon|tue|wed|thu|fri|sat)|\*)')
re.findall(r'(?:(?:(?:1\d|[1-9]|2\d|3[0-1]-*)*|1\d|[1-9]|2\d|3[0-1])|\*) ', '')
re.findall( r'(?:(?:(?:1\d|2[0-3]|\d-*)*|1\d|2[0-3]|\d)|\*) ', '')
test_pattern = r'(?:(?:\d\-*)*|\*)\ '
test_1 = '02-05 14-15 30-31 * *'
# real: верно
test_2 = '70 * * feb sun'
# real: неверно
test_3 = '59 23 2-5 12 0'
# real: верно
test_4 = '20 4 11 dec thu'
# real: верно
test_5 = 'dec mon * * 3'
# real: неверно
for i in range(1, 6):
    print(f'test {i}:')
    if len(re.findall(pattern, eval(f'test_{i}'))) == 1:
        print('верно')
    else:
        print('неверно')
for i in range(1, 6):
    print(re.findall(pattern, eval(f'test_{i}')))
