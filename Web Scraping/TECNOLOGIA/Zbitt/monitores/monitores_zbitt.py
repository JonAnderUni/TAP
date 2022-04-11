import bs4 as bs
import requests
import csv
from common_functions import *

# urllib

url_base = "https://www.zbittbilbao.com"
url = url_base + "/145-monitores-para-ordenador"
i = 0
with open(saveCSVpath("zbitt_monitores.csv"), 'w') as file:
    writer = csv.writer(file)
    while True:
        page = requests.get(url)
        soup = bs.BeautifulSoup(page.text, 'html5lib')
        products = soup.findAll('div', class_="product-container")


        for p in products:
            i += 1
            name = p.find('a', class_="product_img_link")["title"]
            price = p.find("span", class_="price product-price").text
            print(i, finalPrice(price), name)
            writer.writerow(['monitores', 'Zbitt', name, finalPrice(price)])

        next_page = soup.find(id="pagination_next").find("a")
        if next_page:
            url = url_base + next_page["href"]
            print(url)
        else:
            break