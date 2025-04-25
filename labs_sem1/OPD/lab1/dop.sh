echo "dop"
echo "CHROME REQUESTS"
grep 'Chrome/' /Users/nikolajpolisenko/Desktop/access.log > /Users/nikolajpolisenko/Desktop/chrome_requests.txt
echo "Количество запросов"
wc -l /Users/nikolajpolisenko/Desktop/chrome_requests.txt
echo "Количество ответов 4xx и 5xx"
awk '$9 ~ /^[45]/ {print $1}' /Users/nikolajpolisenko/Desktop/access.log | sort | uniq -c