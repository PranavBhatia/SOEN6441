Query 1: Find all transactions from year 2011 and sort them by value (small to high).  
{Trader:Raoul in Cambridge, year: 2011, value:300}  
{Trader:Brian in Cambridge, year: 2011, value:400}  
\---  
Query 2: What are all the unique cities where the traders work?  
Cambridge  
Milan  
\---  
Query 3: Find all traders from Cambridge and sort them by name.  
Trader:Alan in Cambridge  
Trader:Brian in Cambridge  
Trader:Raoul in Cambridge  
Trader:Raoul in Cambridge  
\---  
Query 4: Return a string of all traders’ names sorted alphabetically.  
 Alan Brian Mario Raoul  
\---  
Query 5: Are there any trader based in Milan?  
Trader:Mario in Milan  
Trader:Mario in Milan  
\---  
Query 6: Update all transactions so that the traders from Milan are set to Cambridge.  
{Trader:Brian in Cambridge, year: 2011, value:400}  
{Trader:Raoul in Cambridge, year: 2012, value:1000}  
{Trader:Raoul in Cambridge, year: 2011, value:300}  
{Trader:Mario in Cambridge, year: 2012, value:710}  
{Trader:Mario in Cambridge, year: 2012, value:700}  
{Trader:Alan in Cambridge, year: 2012, value:950}    
\---  
Query 7: What's the highest value in all the transactions?  
highestValue = 1000  