# London-Property-Marketplace
A GUI for exploring properties that are available for temporary rental in London. This project was working on a real-world data set of the London property market from AirBnB, and saved as airbnb-london.csv.

## Introduction
This is the code part of a university project from King's College London 2019/20 4CCS1PPA Programming and Applications, and please note this project is run on BuleJ. Please contact me if you're interested in the whole spec and the written report.
- Supervisors: Michael Kölling, Josh Murphy, Jeffery Raphael
- Authors: [Yichun Zhang](https://github.com/missyQWQ), Liangjie Wang, [Zejin Deng](https://github.com/LilDereky), Runlin Zhou
```
To start:
    Use Login to run the program by right-clicking and selecting “Run JavaFxApplication” in BlueJ.
```

## Description
#### 1. Login/Register Window
- usernames and passwords are stored in “userinfo.txt”.

![login](/screenshots/login.png)
![register](/screenshots/register.png)

#### 2. Welcome Panel
- the 'confirm' button is disabled until the price range is selected.
- a warning window will pop up if the maximum price equal to or less than the minimum price is selected.
- user instruction is available on the left-top corner when users click the red info icon.

![welcome](/screenshots/welcome.png)

#### 3. Statistics Panel
- 4 distinct sections displaying 8 information:
  1. Number of available properties;
  2. Average number of reviews;
  3. Number of entire home/apartments;
  4. The most expensive property;
  5. Number of private rooms;
  6. The cheapest property;
  7. The most expensive borough;
  8. The most available room.
- these statistics are based on the matched properties users select in the welcome panel.
- forward and back buttons allow users to cycle through the data
- maintainability - future developer can easily put more or delete information without adding or deleting sections.

![statistics](/screenshots/statistics_panel.png)

#### 4. Map Panel
- matched properties are shown on the map. Different sizes of circles represent the number of properties in different boroughs. The smaller the size of the circle, the less matched properties this borough contains.
- the number of matched properties will appear when users hover over a specific borough name.
- a new window with a table of all the matched properties will appear when users click a specific borough name. Properties can be listed in different order by selecting options in 'sort by'.
- a new window with a property description will appear when users click a specific property of the table. It contains property name, ID, neighborhood, hostname, room type, price, the minimum number of nights, and the number of reviews on the left-hand side, and a Google street view on the right-hand side.
- add or remove the property from 'My favorites' panel by clicking 'Add to Favorites!' or 'Cancel Favorite'.

![map](/screenshots/map.png)
![propertiesList_window](/screenshots/propertiesList_window.png)
![propertiesDescription_window](/screenshots/propertiesDescription_window.png)

#### 5. My Favorites Panel
- a list of names of the favorite properties on the left-hand side.
- click a specific property to display its details in the right-hand side.
- click 'Detail' button to open the property description window for more information.
- click 'Refresh' button to update the favorites list in case of any 'Cancel Favorite' operations.

![detail](/screenshots/detail.png)
