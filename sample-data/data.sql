
ALTER TABLE IF EXISTS ONLY public.exercise DROP CONSTRAINT IF EXISTS pk_exerxise_id CASCADE;




DROP TABLE IF EXISTS public.exercise;
CREATE TABLE exercise (
                       id serial NOT NULL,
                       title text,
                       question text
);

INSERT INTO exercise VALUES (1,'Football team management', 'You work  in the management of a football club, your responsibility is to control the budget of the team.The squad contains 25 players, and has 3 managers.
goalkeepers earn weekly 1000$, defenders 1500$, midfielders and strikers 2000$
managers earn weekly 500$
club members have names, ages
Your work is to calculate the transfer budget (season start budget - salaries). The transfer market opens in June, (its september 1 now), the yearly budget of the club 10 000 000$, you are a volunteer, so you dont have to  calculate yourself.'
 );
 INSERT INTO exercise VALUES (2, 'Game shop', 'You want to earn some money, so you start selling video games. You sell games in 3 categories: FPS, RPG, Simulator.
All of the games have a release year, category, platform and price.
There are 3 types of platform: Playstation, xbox, and pc.

Every month is like a circle: in the first 5 days (you are open every day, a real business man doesn''t relax) there are customers between 10-15, the other days there are only between 5 and 10, they buy randomly one game.

Your supplier supplies instantly after every customer, so you have a consistent supply.
The profit (sold games - sold games price 50% (you import the games from China)).
Calculate your profit for 3 months, the games depend on you.(just a tip: simulate months and for simplicity calculate  30 days for a month)
');
INSERT INTO exercise VALUES (3, 'Farm', 'In the far future people on Mars developed multiple special plants with
special effects, which were able to grow food more efficiently based on
their nature.
There could be 3 types of plants on a farm: almond trees, spruces, and
junipers. At least 2 of every type is present. The farm knows the total food
produced.
All plants produce food every month (Spruce-26 Almond-50, Juniper-14),
which can be boosted or reduced by different events. Every month the
production of each is growing by 4 by default. Since Spruces and Junipers
are evergreens, they can grow leaves on their own every 5 months,
increasing their production by 8. These two can also be at max production
at 70 (can&#39;t be more than that), at that point they speak and say &quot;&lt;Name&gt;
at full production!&quot;.
*Almond trees, on the other hand, are very effective, when their production
falls below 40, it is doubled!
Both almond trees and spruces have special attributes, they can grow a
shroom every month, which has a chance (almond: 8%, spruce: 5%) that
boosts the production by (almond: 10, spruce: 15) of that plant. Both plants
can also rot every month with a chance of (almond: 13%, spruce: 4%)
which reduces their production by (almond: 18, spruce: 20). Shroom
growing always happens first! If any plant rots, no food is produced that
month at all.
What is the production total on the farm after 80 months?');
INSERT INTO exercise VALUES (4, 'Network', 'In a home Network, there are multiple Devices with multiple attributes and
capabilities.
There are 3 types of Devices: Connected, Normal and Smart. The Network
knows about all Devices.
Every Device has an age and a battery life which is set when they are
manufactured.
Smart and Normal Devices have an actual screen size as well, while
Connected Devices know the number of all other Connected Devices on
the Network. Smart has an additional name attribute which has to be
unique (just don’t write the same for 2), also they can show the number of
Normal Devices which remaining power differs from theirs within a range by
a given amount.
Normal Devices have an additional attribute as well, we know the year
when they were manufactured.
Also, all of them are able to calculate their own remaining power.
This differs based on the Device:
● Connected - loses 7 for every age, have 20 more for each Connected
Device on the Network
● Smart - loses 15 for every age, also loses a fix amount based on their
screen size (
● EDTV - 5, HD - 10, FULL HD - 15, UHD - 20)
● Normal - loses 3 for every age, if it was manufactured in 2000 or later
its power is doubled if earlier it is halved
Implement these classes and their methods using the OOP principles!');
INSERT INTO exercise VALUES (5, 'Taxi Company', 'You are to model a Taxi Company&#39;s annual (52 week) passenger amount.
The Company has Cars and Drivers, it knows about all of them.The Taxi Company can have 3 types of Cars available: Gasoline user,
Electric and Self-Driving.
Each Car has a Unique id, a Cost (Gasoline - 350, Electronic - 400, Self-
Driving - 740) and the Amount of passengers they will carry to their
destination per week.
Gasoline Cars require a Driver and they have a Maintenance cost (20,
+10% each week) as well. Electric cars require a Driver too.
A Driver has a Mobile-Number (5 digit number from 00001 or random), a
Name, an Age, a Salary (salary is the same as cost for cars) and also how
Experienced they are (Beginner, Advanced, Professional). The Drivers all
know each other&#39;s Mobile number (only the number, not which driver it
belongs to).
Based on this Experience (which we gave to each Driver randomly), they
can handle more rides per week (Beginner - 15, Advanced - 25,
Professional - 40 -&gt; these are known by the car). The Drivers for the Cars
are chosen randomly.
You can assume every passenger pays 1 unit of money.
Self-Driving Cars are capable of carrying 70 passengers per week.The Company can and will buy more Cars and Drivers if it has the money,
but they can only buy Electronic or Self-Driving Cars (50-50 chance). For
Electronic, they need to hire a Driver as well, which has a random
Experience type from the 3 available.
Whenever a new Self-Driving Car is added to the Company&#39;s Car arsenal,
all other Self-Driving Cars are out of order for maintenance for 1 week.
How many passengers did the Company gave a ride over a year?');
INSERT INTO exercise VALUES (6, 'Blockbuster', 'Blockbuster was a provider of home movie and video game rental services. Although now bankrupt, in its heyday Blockbuster stores were the go-to rental shops all across America.
A Blockbuster Store has a monthly revenue based on how much and what kind of Products the customers rent. The Store knows about all its Products, and whether or not they are available at the moment.
The following types of Products are available at Blockbuster: Movie, TVShow, Music and VideoGame. Each Product has a title, a release date, a daily rental cost and the original retail price. All Products can be rented for anywhere between 3-14 days.
Every day, there is a 75% chance that a customer walks in the Store to rent a Product. Customers are so eager to rent something, that they will always just pick the first Product they see from the currently available collection. The customer pays the full rental cost on the spot, based on how many days they want to rent it. The number of days is determined at random. The Store adds the new income to its monthly revenue, and the Product becomes unavailable for the duration of the rental.
Blockbuster only serves trustworthy customers, thus we can assume that the Products will always be returned, and always on time. Additionally, customers only rent one Product at a time, and there is only one customer every day (if there is one).
Products are available on different Platforms. They can be on CD, DVD, Blu-ray or VHS. Movies and TVShows are available on a Platform based on when they were released. If they were released before 2000, they are on VHS. From 2000-2010 they are on DVD, and after 2010 they are on Blu-ray. All Music Products are on CD, and all VideoGame Products are on DVD, regardless of their release date.
Some select Products were really popular, and became BlockbusterFavorite. These and only these Products are also available for purchase for their original retail price. When that happens, the Store removes it from its collection.
Using OOP concepts and principles, based on the above, simulate a Blockbuster Store for 3 months, where every month lasts for 30 days!
');
INSERT INTO exercise VALUES (7, 'Concert Organiser','A Concert Organiser company organises three kinds of concerts: indoor, outdoor and festival concerts.
Store every concert’s main band, warm up band, capacity, style (depends on the main band).
Different venues have different capacity and duration, indoor concerts can hold 3000 people, and take 1,5 hours, outdoor concerts hold 5000 people, and take 2 hours and festivals take 6 hours, with 8000 people at the same time.
Unfortunately outdoor concerts have to be cancelled in case of raining (with 30% chance).
Ticket prices are somewhere between 12000-15000 Ft (one concert has only one kind of tickets).
Each concert has a full house with 80% chance. If not, 70%-80% of tickets are sold.
They have also bands to work with: Main and Warm up bands.
Every band has a name and a style (Rock, Pop or Jazz).
Main bands got to decide who is going to cheer up the crowd before they get to the stage. The first Warm up band who has the same style wins this honor.
Let’s talk about alcohol a bit:
Every guest is a huge beer fan. They drink 1 pint of beer every half an hour. Beer prices are the following: indoor - 600 Ft, outdoor - 800 Ft, festival - 1000 Ft.
Calculate the company’s profit from 10 concerts. They can keep 40% of the ticket sales and the full income from the bar.
');
INSERT INTO exercise VALUES (8, 'Train Company', 'You work at the train company as an economist. Your boss asks you to calculate the annual income of the company. You have to be attentive because the company was unprofitable so far.

There are 3 types of trains: Passenger, IC and Freight.
It''s important to have at least 2 of each train.
Each train has a unique serial number.

Every train has a cost: IC 1,200$/month, Passenger and Freight 1,000$/month.

Between 115 and 250 people travel daily on the trains.
The train ticket is 1.50$ for the passenger train, IC tickets cost 50 cents more because of the seat fare. 25% of people buy tickets on the train, which is 2 dollars more expensive in both cases. The freight train has no passengers.

The revenue of the freight train is 550$/month.
Other revenues:
- If the freight train goes abroad (with a 35% chance per month), it adds 110$ to its revenue.
- On the passenger train there is a 10% chance and on the IC there is an 8% chance each month that 20% of the travelers will be punished. Which means 6$ plus per person.

Your task is to simulate this train company for 2 years, and print its expenses, income and profits.');