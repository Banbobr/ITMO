# 73 вариант
# 73: 1)55 92 17 74 2)72
# 55) 1 1 1 0 0 1 1
# 92) 1 0 0 0 1 1 0
# 17) 0 0 1 0 0 0 1
# 74) 0 0 1 1 1 0 1
# 72) 0 0 1 1 1 0 0 1 0 0 0 0 1 0 0
def rightmes(code):
    r1, r2, i1, r3, i2, i3, i4 = [int(i) for i in code]
    contr_s1 = (r1 + i1 + i2 + i4) % 2
    contr_s2 = (r2 + i1 + i3 + i4) % 2
    contr_s3 = (r3 + i2 + i3 + i4) % 2
    contr_s = int(f'{contr_s3}{contr_s2}{contr_s1}', 2)
    if contr_s == 0:
        print('Нет ошибки в сообщении')
        print(f'Сообщение: {i1}{i2}{i3}{i4}')
    elif contr_s == 1:
        print('Ошибка в r1')
        print(f'Правильное сообщение: {i1}{i2}{i3}{i4}')
    elif contr_s == 2:
        print('Ошибка в r2')
        print(f'Правильное сообщение: {i1}{i2}{i3}{i4}')
    elif contr_s == 3:
        print('Ошибка в i1')
        print(f'Правильное сообщение: {int(not i1)}{i2}{i3}{i4}')
    elif contr_s == 4:
        print('Ошибка в r3')
        print(f'Правильное сообщение: {i1}{i2}{i3}{i4}')
    elif contr_s == 5:
        print('Ошибка в i2')
        print(f'Правильное сообщение: {i1}{int(not i2)}{i3}{i4}')
    elif contr_s == 6:
        print('Ошибка в i3')
        print(f'Правильное сообщение: {i1}{i2}{int(not i3)}{i4}')
    elif contr_s == 7:
        print('Ошибка в i4')
        print(f'Правильное сообщение: {i1}{i2}{i3}{int(not i4)}')


rightmes(input('Введите набор из 7 цифр 0 и 1: '))
