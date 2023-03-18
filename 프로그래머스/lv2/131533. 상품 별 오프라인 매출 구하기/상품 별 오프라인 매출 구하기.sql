SELECT A.PRODUCT_CODE, SUM(B.SALES_AMOUNT * A.PRICE) AS SALES
FROM PRODUCT AS A JOIN OFFLINE_SALE AS B
ON A.PRODUCT_ID = B.PRODUCT_ID
GROUP BY A.PRODUCT_CODE
ORDER BY SALES DESC, A.PRODUCT_CODE ASC;