from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time

def test_dashboard():
    
    driver = webdriver.Chrome()

    try:
        driver.maximize_window()
        driver.get("https://ua.segwise.ai/qa_assignment")

        wait = WebDriverWait(driver, 20)

       
        login_with_email_btn = wait.until(
            EC.element_to_be_clickable((By.XPATH, "//button//span[contains(text(),'Log in with email')]"))
        )
        login_with_email_btn.click()

        #this is for email field
        email_field = wait.until(
            EC.visibility_of_element_located((By.CSS_SELECTOR, "input[autocomplete='email']"))
        )
        ActionChains(driver).move_to_element(email_field).click().send_keys("qa@segwise.ai").perform()

        
        password_field = wait.until(
            EC.visibility_of_element_located((By.CSS_SELECTOR, "input[type='password']"))
        )
        ActionChains(driver).move_to_element(password_field).click().send_keys("segwise_test").perform()

        
        login_btn = wait.until(
            EC.element_to_be_clickable((By.XPATH, "//button[@type='submit']"))
        )
        login_btn.click()

       
        wait.until(EC.url_contains("qa_assignment/home"))

        
        cost_chart = wait.until(
            EC.visibility_of_element_located((By.XPATH, "//*[contains(text(),'Cost Per Install')]"))
        )

        if cost_chart.is_displayed():
            print("Dashboard chart 'Cost Per Install' is visible!")
        else:
            print("Chart not found!")

    except Exception as e:
        print("Test Failed:", str(e))
    finally:
        time.sleep(5)
        driver.quit()

if __name__ == "__main__":
    test_dashboard()
