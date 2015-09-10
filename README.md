# Zillow Investment Finder
This program will retrieve and parse XML data from Zillow for a range of addresses and identify the property with the best estimated price to rent ratio. Before starting, make sure to replace the commented default XML path with your own path. Also, replace the zwsID in the API class with your own, otherwise you'll hit the Zillow maximum API call limit very quickly.

When running the program, the street name should include an identifier like "St", "Ave", "Pkwy" (e.g. "Soggy Dirt Ln") to avoid ambiguity. The program will try every other address in the given range (i.e. addresses on one side of the street), so it is advisable to avoid large ranges that include many non-existent addresses, since this will take more time to process and waste API calls.
