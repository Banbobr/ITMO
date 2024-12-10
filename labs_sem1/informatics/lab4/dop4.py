from time import time

import task
import dop1
import dop2
import dop3

task_list = []
for _ in range(10000):
    start_time_task = time()
    task.convertation()
    end_time_task = time()
    task_list.append((end_time_task - start_time_task) * 100)
print(f'Среднее время выполнения основного задания: {sum(task_list) / len(task_list)}')

dop1_list = []
for _ in range(10000):
    start_time_dop1 = time()
    dop1.convertation()
    end_time_dop1 = time()
    dop1_list.append((end_time_dop1 - start_time_dop1) * 100)
print(f'Среднее время выполнения допа 1: {sum(dop1_list) / len(dop1_list)}')

dop2_list = []
for _ in range(10000):
    start_time_dop2 = time()
    dop2.convertation()
    end_time_dop2 = time()
    dop2_list.append((end_time_dop2 - start_time_dop2) * 100)
print(f'Среднее время выполнения допа 2: {sum(dop2_list) / len(dop2_list)}')

dop3_list = []
for _ in range(10000):
    start_time_dop3 = time()
    dop3.convertation('schedule_dop3.json', 'schedule_dop3.xml')
    end_time_dop3 = time()
    dop3_list.append((end_time_dop3 - start_time_dop3) * 100)
print(f'Среднее время выполнения допа 3: {sum(dop3_list) / len(dop3_list)}')
