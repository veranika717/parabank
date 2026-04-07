# ParaBank Smoke Test Cases

## TC-01: Verify Login Page Loads

**Preconditions:** None

**Steps and Expected Results:**

| Step | Expected Result |
|------|-----------------|
| 1. Open https://parabank.parasoft.com/parabank/index.htm | Login section is displayed |
| 2. Verify Username field is present | Username field is visible and editable |
| 3. Verify Password field is present | Password field is visible and has type="password" (input masked with dots/stars) |
| 4. Verify LOG IN button is present | LOG IN button is visible and clickable |
| 5. Verify "Forgot login info?" link is present | Link is visible |
| 6. Verify "Register" link is present | Link is visible |

---

## TC-02: Verify Successful Login

**Preconditions:**
- Test user exists in the system: username = "john", password = "demo"
- Login page is open

**Steps and Expected Results:**

| Step | Expected Result |
|------|-----------------|
| 1. Enter valid username "john" into Username field | "john" appears in the Username field |
| 2. Enter valid password "demo" into Password field | Password characters are masked (dots/stars) |
| 3. Click "LOG IN" button | User is redirected to Accounts Overview page. URL contains "overview". Welcome message with username is displayed. User is successfully logged in. |

---

## TC-03: Verify Failed Login (Invalid Credentials)

**Preconditions:** Login page is open

**Steps and Expected Results:**

| Step | Expected Result |
|------|-----------------|
| 1. Enter invalid username "wronguser" into Username field | "wronguser" appears in the Username field |
| 2. Enter invalid password "wrongpass" into Password field | Password characters are masked (dots/stars) |
| 3. Click "LOG IN" button | User remains on login page. URL does NOT contain "overview". Error message is displayed: "The username and password could not be verified." |

---

## TC-04: Verify Register Link

**Preconditions:** Login page is open

**Steps and Expected Results:**

| Step | Expected Result |
|------|-----------------|
| 1. Click "Register" link | User is redirected to Registration page. URL contains "register". |

---

## TC-05: Verify Forgot Login Info Link

**Preconditions:** Login page is open

**Steps and Expected Results:**

| Step | Expected Result |
|------|-----------------|
| 1. Click "Forgot login info?" link | User is redirected to Customer Lookup page. URL contains "lookup". Page contains form for password recovery (First Name, Last Name, Address fields). |
