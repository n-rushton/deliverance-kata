# deliverance-kata instructions

## Introduction

Deliverance is a company based in London that sends parcels around the country, and they have announced that they are
developing a public library in which users can use their postage calculator to know the cost of sending a parcel in any
supported currency. They have already informed to all their customers that the public method to be used in their library
is:

`public Money calculate(int weight, int height, int width, int depth, Currency currency)`

- `Currency` is an enum provided by the library as well which contains the supported currencies. Currently, they are
  GBP, USD and EUR
- `Money` is also an object provided by the library with two fields, `Currency` and `amount`.

## Problem

You will need to implement the library that was announced, the good thing is that the stack has not been defined, so you
may choose any language that you prefer. but you **cannot change the public method announced by Deliverance**.

Deliverance has different ways of calculating their prices depending on the size of the parcel:

- parcels that weight up to 60 and that neither height, width and depth are greater than 229, 162 and 25 respectively
  cost 120 GBP
- parcels that weight up to 500 and that neither height, width and depth are greater than 324, 229 and 100 respectively
  cost the weight times 4 GBP.
- parcels greater than the previous ones cost either the weight times 6, or all dimensions multiplied together and
  divided by 1000 and multiplied by 6. Whichever is greater in GBP.

Lastly the resulting object should convert the base currency (GBP) to the currency requested in the `calculate`
method. **if the parcel is requested in any other currency that is not the base currency, then a tax of 20 GBP is
charged to the conversion**.

Conversion rates are:
- 1 GBP = 1.19 EUR
- 1 GBP = 1.25 USD
