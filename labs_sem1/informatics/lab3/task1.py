"""
глаза: 2) X
нос: 0) -
рот: 4) \
смайлик: X-\
"""
import re

pattern = r'X-\\'
test_1 = "XXX-wrf-X-\\c\n\nwweew\\X-]f]X-\\"
# real: 2
test_2 = "x--\nx-\\X_\\rrrX-\\]]][["
# real: 1
test_3 = "РегулX-ярные выражения (regular expressions) — \
          последовательность симв(X-\\)олов, опреде-\\ляющая шаблон дляX-\\ поиска в строках."
# real: 2
test_4 = "19001GGG*9d9d9(*&^%$wkhuXXXX---\\\\ sii 9888kp ------ 1000 - 7ssdsdsd"
# real: 0
test_5 = "{{{]]][[}}\\||||svn99X-\\X-\\X-\\X-\\idiid"
# real: 4
for i in range(5):
    print(f'test {i + 1}:')
    print(len(re.findall(pattern, eval(f'test_{i + 1}'))))
