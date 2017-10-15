# EventGrid

## Scenario
- Your program should randomly generate seed data.
- Your program should operate in a world that ranges from -10 to +10 (Y axis), and -10
to +10 (X axis).
- Your program should assume that each co-ordinate can hold a maximum of one
event.
- Each event has a unique numeric identifier (e.g. 1, 2, 3).
- Each event has zero or more tickets.
- Each ticket has a non-zero price, expressed in USDollars.
- The distance between two points should be computed as the Manhattan distance.

## Instructions
- You are required to write a program which accepts a user location as a pair of co-ordinates, and returns a list of the five closest events, along with the cheapest ticket price for each event
- Please detail any assumptions you have made.
- How might you change your program if you needed to support multiple events at the
same location?
- How would you change your program if you were working with a much larger world
size?

## How To Run
From the project root directory:
```
cd src/
javac ViagogoGrid.java
java ViagogoGrid
```
## Assumptions
- Number of events range from [0, 441]
    - More generally, it ranges anywhere from [0, (LENGTH*2 + 1)^2]
- Number of tickets in each event range from [0, 100]
    - The price of each ticket ranges from [$0.01, $5000.00]
- Events with no tickets will display price() as "No Tickets Available"
- Each location can only have one event.
- Each event may have zero or more tickets.
- Valid input constitutes two integer values separated by a single comma
- User will want to loop input and search the 5 nearest through the same seed data using different start points

## Questions
#### How might you change your program if you needed to support multiple events at the same location?
The __Point__ class currently has a data member called __event__, which is basically a single __Event__ that has its own list of tickets and such. In addition it also holds a __distanceFromStart__ member for purposes of handling the query. A possible change would be to turn the __Event event;__ data into a __Collection__ of __Events__.

After this is done, a way to get the nearest _N_ events could be from a breadth-search type of thing where you would search points of distance (1, 2, 3, 4, ..., etc) from the start, and try to find the _N_ cheapest events in the closest levels first. So it would be something like this:

```
for each Manhattan Distance level (1...end-of-map)
  while there are uncounted events in this level AND
        we don't have N events yet
    add next cheapest to the list
```

#### How would you change your program if you were working with a much larger world size?
If we blew up the data to numbers larger than an __int__ or any __long long__ could hold, it would have to be stored in some kind of external memory than can be referenced by the coordinates. Maybe feeding a starting point to the program would retrieve a smaller map centered around that point, and the program would then have a much more CPU and Memory friendly map that could allow this program to run normally.
