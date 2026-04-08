# ParaBank Bug Reports

## Bug Report #1: Duplicate Content in Latest News Section

**Title:** All links in "Latest News" section open the same article

**Severity:** Medium

**Priority:** Medium

---

### Steps to Reproduce

| Step | Action |
|------|--------|
| 1 | Open the main page: https://parabank.parasoft.com/parabank/index.htm |
| 2 | Locate the **"Latest News"** section on the right side of the page |
| 3 | Click on the first link: **"ParaBank Is Now Re-Opened"** |
| 4 | Read the article content |
| 5 | Go back to the main page |
| 6 | Click on the second link: **"New! Online Bill Pay"** |
| 7 | Compare the content with the first article |

---

### Actual Result

All three links open **the same article** with identical content. The content does not change based on which news link is clicked.

### Expected Result

Each link should open a different article corresponding to its title.

---

## Bug Report #2: Missing Field Validation in "Send to Customer Care" Form

**Title:** "Send to Customer Care" form accepts invalid email, phone number, and empty fields

**Severity:** Medium

**Priority:** Medium

---

### Steps to Reproduce

| Step | Action |
|------|--------|
| 1 | Open the main page: https://parabank.parasoft.com/parabank/index.htm |
| 2 | Scroll down to the **"Send to Customer Care"** form |
| 3 | Enter `123` in the `Name` field |
| 4 | Enter `test` (without `@` and domain) in the `Email` field |
| 5 | Enter `abc` (letters instead of numbers) in the `Phone` field |
| 6 | Leave the `Message` field empty |
| 7 | Click the **"SEND TO CUSTOMER CARE"** button |

---

### Actual Result

The form submits (or tries to submit) **without any validation**:

| Field | Issue |
|-------|-------|
| Email | Missing `@` and domain (e.g., `test` is accepted) |
| Phone | Letters are accepted instead of digits only |
| Message | Empty field is accepted |
| Phone | No country code validation |

### Expected Result

The form should validate all fields before submission:

| Field | Validation Rule |
|-------|-----------------|
| Email | Must contain `@` and a domain (e.g., `user@example.com`) |
| Phone | Accept only digits, spaces, and `+` (optional country code) |
| Name | Should not be empty |
| Message | Should not be empty |

**Error messages** should be displayed clearly next to the invalid fields.

---

## Summary

| Bug ID | Title | Severity |
|--------|-------|----------|
| #1 | All news links open the same article | Medium |
| #2 | "Send to Customer Care" form has no field validation | Medium |
