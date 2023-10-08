Problem Statement
Design and build an in-memory SQL like a database.

Requirements:
Ability to create multiple databases
Ability to create multiple tables in a database
Each table should have schema defined with it
Schema is a list of columns and datatype of each column. There are two data types Integer(allowed values -256 to +256) and String(allowed upto 20 chars) but should be extendable to others (think Double, Chars[] and so on)
Schema would have two optional parameters: single indexes and compound indexes.
Ability to add/update multiple rows to a table
Each row should be schema verified before adding
Each row addition should have it’s attributed updated in indexes if any
Ability to create/drop singxle/compound indexes at any point of time
Ability to search in a table by column filters
This search should consider created index if possible
Search by SQL like strings is NOT expected (NO parsers expected)
Write a driver class for demo purposes. Which will execute all the operations in one place in the code and have test cases


Bonus Extensions:
Ability to create foreign key relationships.
With this, every write operation(create/update/delete) should have a cascading effect on the linked tables.

Guidelines:
Use any IDE
Write a driver class for demo purposes. Which will execute all the commands in one place in the code and have test cases.
You should store the data in memory using a language-specific data structure.
You can print the output in the console. Do not create any UI for the application.
Implement clear separation between your data layers and service layers.
Please prioritize code compilation, execution, and completion
Work on the expected output first and then add bonus features of your own.
Expectations:
Your code should cover all the mandatory requirements explained above.
Your code should be executable and clean.
Your code should be properly refactored, and exceptions should be gracefully handled.
Please add any assumptions taken in a README file. Eg 1: Assume authentication and authorization are already taken care of. Eg 2: Assume you are building for a small business but extensible enough for future use cases
Evaluation Criteria:
Separation of concerns
Readable Code
Choices on data structures (lists vs sets, maps vs for)
Choices on patterns (repositories, abstractions)
Low-Level design
Functional correctness
Concurrency handling (Bonus Points)
Extension problems (Bonus Points)
Working code
Test Coverage (Bonus Points)
Language proficiency
Scalability
You shall be able to finish the code within 90 mins and then mail the zipped code to nikita.futur.con@phonepe.com and shivani.sahraot@phonepe.com. Any delays in submission than 120 min will lead to disqualification