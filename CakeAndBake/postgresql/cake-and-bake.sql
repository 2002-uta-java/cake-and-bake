/*
 * Create table with an id, name, and description (likely will add more things)
 */
create table recipes (rcp_id serial constraint p_rcp_id primary key,
rcp_name varchar(40) not null,
rcp_descript varchar(500) not null );

/*
 * Create recipe steps which link recipe id's to recipe steps. The recipe and id and step number, together, form a primary key. Finally have instructions for this step.
 */
create table recipe_steps (rcp_id int4 references recipes(rcp_id) not null,
rcp_step_no int4 not null,
rcp_step_inst varchar(500) not null,
primary key (rcp_id,
rcp_step_no));

drop table recipes;
drop table recipe_steps;

truncate table recipes, recipe_steps;

insert into recipes(rcp_name, rcp_descript) values ('Cheesecake', 'Chef Anna Olson takes you step by step through her amazing New York cheesecake recipe.');

insert into recipe_steps values (1, 1, 'Preheat the oven to 350ºF');
insert into recipe_steps values (1, 2, 'For the crust, stir the graham crumbs, sugar and melted butter until evenly combined and press this into the bottom of an ungreased 9-inch springform pan.');

insert into recipe_steps values (1, 3, 'Bake this for 10 minutes, then cool. Brush the sides of the pan with a little melted butter.');

insert into recipe_steps values (1, 4, 'For the cheesecake, increase the oven temperature to 400ºF (205 C).');
insert into recipe_steps values (1, 5, 'Beat the cream cheese until light and fluffy. Add the 1 ¼ cups of sugar a little at a time, and scraping the sides and bottom of the bowl often.');
insert into recipe_steps values (1, 6, 'Beat in the cornstarch, vanilla and lemon zest.');
insert into recipe_steps values (1, 7, 'Beat in the eggs one at a time, on a lower speed, and scraping after each addition, then beat in the yolk.');
insert into recipe_steps values (1, 8, 'Still on low speed, beat in ¾ cup of sour cream. Scrape this over the cooled crust.');
insert into recipe_steps values (1,9, 'Bake the cheesecake for 10 minutes at 400ºF (205 C) and then reduce the oven temperature to 225ºF (107 C) and bake for 25 more minutes. Turn off the oven, and leave the cheesecake in for an hour, cracking the oven door after 30 minutes. While the cheesecake is baking, prepare the sour cream layer.');
insert into recipe_steps values (1, 10, 'Stir the remaining ¾ cup of sour cream with the remaining 2 Tbsp of sugar and the lemon juice. Spread this over the top of the cheesecake as soon as it has come out of the oven.');
insert into recipe_steps values (1, 11, 'Allow the cheesecake to cool completely to room temperature, then carefully run a spatula around the outside of the cheesecake to loosen it from the pan, then chill the cheesecake for at least 6 hours before slicing and serving. The cheesecake will keep, refrigerated, for up to 4 days.');












