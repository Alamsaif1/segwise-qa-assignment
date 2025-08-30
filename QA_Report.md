QA Report – Segwise.ai Dashboard



1\. Found Issues / Bugs



Issue 1: Incorrect Percentage Display

-Steps to Reproduce:

&nbsp; 1. Login with test credentials

&nbsp; 2. Navigate to dashboard

&nbsp; 3. Check Cost Per Install and ROAS widgets

-Expected: If no data exists, widget should display `0%` or `N/A`

-Actual: Widgets display `-100%` even when values are `$0` or `0%`

-Severity: High  

-Type: Data/Logic Bug  



---



&nbsp;Issue 2: Charts Display Flat Zero Lines

-Steps to Reproduce:

&nbsp; 1. Select any date range

&nbsp; 2. Observe D1 ROAS and D7 ROAS charts

-Expected: Graphs should show actual data trend or a message like “No data available”

-Actual: Charts display a flat zero line with confusing percentage indicators  

-Severity: Medium  

-Type: Data Visualization Issue  



---



Issue 3: Confusing Date Selector Labels

-Steps to Reproduce:

&nbsp; 1. Go to top bar report type dropdown

&nbsp; 2. Observe labels such as “7 Days ending 14 Oct v 7 Days ending 15 Oct”

-Expected: A clearer message like “Comparing last 7 days vs previous 7 days”

-Actual: Labels are hard to interpret for non-technical users  

-Severity: Low  

-Type: UX Issue  



---



&nbsp;Issue 4: Welcome Message Formatting

-Steps to Reproduce:

&nbsp; 1. Login with test credentials

&nbsp; 2. Look at the header

\- Expected: Message should display: “Welcome back, Saif” or “Hello, Saif”

\- Actual: Message displays “Welcome back, hello” which is redundant  

\- Severity: Low  

\- Type: UI/UX Content Issue  



---



&nbsp;Issue 5: Search Bar Lacks Guidance

\- Steps to Reproduce:

&nbsp; 1. Navigate to dashboard

&nbsp; 2. Look at search bar labeled “Search modules”

\- Expected: Placeholder should guide user (e.g., “Search modules like Filters, Reports, Charts”)  

\- Actual: Placeholder text is vague, no hint on what can be searched  

\- Severity: Low  

\- Type: UX Enhancement  



---



&nbsp;2. Regression Checklist



| Test Case ID | Area              | Test Description                              | Expected Result                       |

|--------------|-------------------|-----------------------------------------------|---------------------------------------|

| R1           | Login             | Verify login with valid credentials           | User successfully logs in             |

| R2           | Login             | Verify login with invalid credentials         | Error message shown                   |

| R3           | Filters \& Boards  | Apply date filter                             | Dashboard updates with filtered data  |

| R4           | Filters \& Boards  | Apply multiple filters (date + region)        | Correct filtered data displayed       |

| R5           | Custom Reports    | Create and save a new report                  | Report saved successfully             |

| R6           | Custom Reports    | Edit an existing report                       | Report updated correctly              |

| R7           | Charts            | Verify main metrics/charts load correctly     | Charts visible without errors         |

| R8           | Charts            | Check percentage values vs actual chart data  | Values match correctly                |

| R9           | Responsiveness    | View dashboard in smaller resolution (1366x768)| Layout adjusts without overlaps       |

| R10          | UX Consistency    | Check placeholders \& labels for clarity       | User-friendly text shown              |



---



3\. Suggestions for Improvement

\- Fix percentage calculation logic when no data exists (`0%` instead of `-100%`).  

\- Add empty state messages in graphs (e.g., “No data available for this period”).  

\- Simplify date range comparison labels for clarity.  

\- Improve welcome message personalization (use username instead of “hello”).  

\- Enhance search bar placeholder with examples for better UX.  



