
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