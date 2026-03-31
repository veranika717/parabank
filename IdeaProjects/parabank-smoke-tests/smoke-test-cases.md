# parabank smoke test cases

## tc-01 verify login page opens

steps:
1. open https://parabank.parasoft.com/parabank/index.htm

expected result:
login section is visible
- username field
- password field (input masked)
- LOG IN button
- "Forgot login info?" link
- register link
---

## tc-02 verify username field

steps:
1. locate username field
2. enter text

expected result:
text appears in username field

---

## tc-03 verify password field

steps:
1. locate password field
2. enter password

expected result:
password characters are hidden

---

## tc-04 verify login button(successful login)

steps:
1. enter valid username
2. enter valid password
3. click "log in"

expected result:
user is logged in

---

## tc-05 verify login button(failed login)

steps:
1. enter invalid username
2. enter invalid password
3. click "log in"

expected result:
login fails
user remains on login page
error message is displayed

---
## tc-06 verify empty fields validation

steps:
1. leave username field empty
2. leave password field empty
3. click "log in"

expected result:
login fails
user remains on login page
error message is displayed

---

## tc-07 verify register link

steps:
1. click "register"

expected result:
registration page opens

---

## tc-08 verify forgot login info

steps:
1. click "forgot login info?"

expected result:
password recovery page opens

---

## tc-09 verify enter key submission

steps:
1. enter valid username
2. enter valid password
3. press "Enter" key instead of clicking button

expected result:
user is logged in (same as clicking LOG IN button)