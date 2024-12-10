# 10 -> -10
def perevod(chislo):
    x10 = chislo
    xm10 = []
    while x10 != 0:
        x10, ost = divmod(x10, -10)
        if ost < 0:
            ost += 10
            x10 += 1
        xm10.append(ost)
    return int(''.join(map(str, xm10[::-1])))


try:
    print(perevod(int(input('Введите число: '))))
except TypeError:
    print('Неправильный формат числа1')
except ValueError:
    print('Неправильный формат числа')
