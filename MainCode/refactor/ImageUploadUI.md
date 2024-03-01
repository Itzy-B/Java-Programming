###ImageUploadUI

####Functions:
- ``ImageUploadUI()``
- ``initializeUI()``
- ``uploadAction()``
- ``getNextImageId()``
- ``saveImageInfo()``
- ``getFileExtension()``
- ``saveBioAction()``
- ``createHeaderPanel()``
- ``readUsername()``
- ``createNavigationPanel()``
- ``createIconButton()``
- ``openProfileUI``
- ``notificationsUI()``
- ``openHomeUI``
- ``exploreUI()``

####Functionalities of the Functions:
- ``ImageUploadUI()``
    - Sets the upload image scene and then initializes the ui.

- ``initializeUI()``
    - Creates panels, text area and buttons and sets their allignment.
    - Adds the panels to the frame.

- ``uploadAction()``
    - Creates a file chooser, allows the user to choose a picture and upload.

- ``getNextImageId()``
    - Checks for the saved images then if goes throught the ID list and gets the next image.

- ``saveImageInfo()``
    - Saves the image data, when was it posted, the likes it has, ID, ...

- ``getFileExtension()``
    - Gets the file extension and checks if it is a valid file.

- ``saveBioAction()``
    - Just gets the text on bio, doesn't save.

- ``createHeaderPanel()``
    - Creates the header panel.

- ``readUsername()``
    - Goes into the users file and reads the username.

- ``createNavigationPanel()``
    - Makes the navigation panel with the icons.

- ``createIconButton()``
    - Makes the icons into buttons and adds action listener to and forwards them to according pages.

- ``openProfileUI``
    - Checks if the username is in the files then forwards them to their profile.

- ``notificationsUI()``
    - Creates an object to notificationUI

- ``openHomeUI()``
    - Creates an object to homeUI

- ``exploreUI()``
    - Creates an object to exploreUI