import {test, expect} from '@playwright/test';

test('First Playwright Test', async({page})=>{

    await page.goto('https://www.youtube.com/');
    await page.getByPlaceholder('Search').fill('Playwright automation');
    // const searchElement:any = await page.locator("//div[@role='option']");
    const searchElement:any = await page.locator("//div[@role='listbox']//div//div//div");
    console.log(await searchElement.allTextContents());
    
    
})