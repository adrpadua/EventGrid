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

## Design
#### Model
- Classes for Events and Tickets made to resemble real-world properties like event location, available tickets, and ticket pricing.
- __Event__ is initialized with a list of tickets and an ID. The __toString()__ method is overwritten to match the format of the desired output from the question prompt.
- __Ticket__ is just a class to represent tickets on sale. Each ticket has a price and is held by __Events__ in a __List__.

#### World
- The generation of the map and the 2D coordinate point representation is held in the world package. I thought this should be abstracted away from the __Event__ and __Ticket__ models because maybe we would want to change the representation of the __World__ map in the future.
- __Points__ are used to hold location data for a(n) event(s). The class holds coordinates and a single __Event__ (which could be changed to a __Collection__ if needed).
- To abstract the logic even more, __Point__ could alternatively implement an __EventLocation__ interface, so other implementations could be made to hold __Events__.

#### Util
- This package contains helpers that are not part of the models or world.
- __Constants__ is a file that holds the important values for seeding the world. This data includes the constant for the world size, max # of events, max price of tickets, and the number _N_, where _N_ is the number of nearest events to find.
- __DistanceComparator__ is a custom Comparator for the __Point__ class. This helps the __PriorityQueue__ sort the points by distance from the start location.
- __RandomGenerator__ handles all the seeding for the data. While the world size and _N_ events are fixed, things like # of events, location of events, # tickets, and ticket price are generated with the methods in this class.

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
