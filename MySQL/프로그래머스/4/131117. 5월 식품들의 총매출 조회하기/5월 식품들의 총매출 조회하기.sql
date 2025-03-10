-- 코드를 입력하세요
SELECT FP.PRODUCT_ID, FP.PRODUCT_NAME, SUM(FO.AMOUNT * FP.PRICE) AS TOTAL_SALES
FROM FOOD_PRODUCT FP JOIN FOOD_ORDER FO
ON FP.PRODUCT_ID = FO.PRODUCT_ID
AND DATE_FORMAT(FO.PRODUCE_DATE, '%Y-%m') = '2022-05'
GROUP BY FP.PRODUCT_ID, FP.PRODUCT_NAME
ORDER BY `TOTAL_SALES` DESC, FP.PRODUCT_ID ASC;