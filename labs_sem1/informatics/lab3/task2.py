# вариант: 2
import re

# pattern = r'ВТ(?: \w+){0,4}\s*[\-]*\s*ИТМО'
pattern = r'ВТ(?:\s*[\-:;,.]*\s*\w+){0,4}\s*[\-:;,.]*\s*ИТМО'
test_0 = 'А ты знал, что  ВТ ---- лучшая кафедра в ИТМО?'
# real: ВТ лучшая кафедра в ИТМО
test_1 = 'ВТ rrr rr rr rr ИТМО'
# real: ВТ rrr rr rr rr ИТМО
test_2 = 'Вт ВТ ВТ ВТ ИТМО'
# real: ВТ ВТ ВТ ИТМО
test_3 = 'ВТ умми12у_г__уимгуимг ИТМО'
# real: ВТ умми12у_г__уимгуимг ИТМО
test_4 = 'ВТ 420 228 ИТМО'
# real: ВТ 420 228 ИТМО
test_5 = 'ВТ ИТМО  ВТ ВТ ВТ ИТМО  ВТ 1 2 3 ИТМО  ВТ ___ ИТМО ВТ ВТ_123 ИТМО'
# real: ВТ ИТМО
# ВТ ВТ ВТ ИТМО
# ВТ 1 2 3 ИТМО
# ВТ ___ ИТМО ВТ ВТ_123 ИТМО
for i in range(6):
    print(f'test {i}:')
    print("\n".join(re.findall(pattern, eval(f'test_{i}'))))
