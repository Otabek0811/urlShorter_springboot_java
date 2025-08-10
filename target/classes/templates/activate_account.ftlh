<#--<!DOCTYPE html>-->
<#--<html lang="en">-->
<#--<head>-->
<#--<meta charset="UTF-8">-->
<#--<title>Title</title>-->
<#--</head>-->
<#--<body style="background-color: darkgray">-->
<#--<h2 style="color: greenyellow; font-size: 40px; text-align: center">-->
<#--    Hello Dear ${username}!-->
<#--</h2>-->
<#--<h3>-->
<#--    You successfully registered your account.-->
<#--</h3>-->
<#--<h3>-->
<#--    Please activate it by clicking on the link below.-->
<#--</h3>-->


<#--<a href="${activationUrl}">Activate</a>-->

<#--<h2 style="color: darkslategray; font-size: 30px">-->
<#--    Learning Spring Boot-->
<#--</h2>-->

<#--</body>-->
<#--</html>-->


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Account Activation</title>
</head>
<body style="margin: 0; padding: 0; font-family: Arial, sans-serif; background-color: #f4f4f4;">

<!-- Main container -->
<table width="100%" cellpadding="0" cellspacing="0" style="background-color: #f4f4f4; padding: 20px 0;">
    <tr>
        <td align="center">

            <!-- Card -->
            <table cellpadding="0" cellspacing="0" width="600" style="background-color: #ffffff; border-radius: 10px; overflow: hidden; box-shadow: 0 4px 10px rgba(0,0,0,0.1);">
                <tr>
                    <td style="background-color: #4CAF50; padding: 20px; text-align: center; color: white;">
                        <h1 style="margin: 0; font-size: 28px;">Welcome, ${username}!</h1>
                    </td>
                </tr>

                <tr>
                    <td style="padding: 30px; color: #333; line-height: 1.6;">
                        <h2 style="color: #4CAF50; margin-top: 0;">Account Registration Successful 🎉</h2>
                        <p>We’re excited to have you on board. Your account has been successfully created, and you’re just one step away from accessing all the features.</p>

                        <p>Please activate your account by clicking the button below:</p>

                        <p style="text-align: center; margin: 30px 0;">
                            <a href="${activationUrl}"
                               style="background-color: #4CAF50; color: white; text-decoration: none; padding: 14px 28px; border-radius: 5px; font-size: 16px; display: inline-block;">
                                Activate My Account
                            </a>
                        </p>

                        <p>If you did not register for this account, please ignore this email.</p>

                        <hr style="border: none; border-top: 1px solid #ddd; margin: 30px 0;">

                        <p style="font-size: 14px; color: #888;">Thank you for joining us,<br><strong>The Spring Boot Learning Team</strong></p>
                    </td>
                </tr>

                <tr>
                    <td style="background-color: #f1f1f1; padding: 15px; text-align: center; font-size: 12px; color: #777;">
                        &copy; 2025 Learning Spring Boot. All rights reserved.
                    </td>
                </tr>
            </table>

        </td>
    </tr>
</table>

</body>
</html>
