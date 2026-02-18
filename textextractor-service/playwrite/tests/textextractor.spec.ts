const { test, expect } = require('@playwright/test');

test.describe('API testomat requests', () => {
    const REQUEST = {
        requestId: "jolir86609@ikanid.com",
        base64Img: "password"
    }
    const PRJ = "second-project-cd17c";

    test('API Post Request', async ({request}) => {
        const res = await request.post('http://localhost:8004/extract/',{
            data:{
                "requestId": REQUEST.requestId,
                "base64Img": REQUEST.base64Img
            }
        });
        expect(res.status()).toBe(200);
        const body = await res.json();
        // USER.token = body.jwt;
        console.log("TOKEN", res);
        // console.log("TOKEN", REQUEST.token);
    });

});
