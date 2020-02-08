# Darklaf - A Darcula Look and Feel

[![Maven Central](https://img.shields.io/maven-central/v/com.github.weisj/darklaf.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.weisj%22%20AND%20a:%22darklaf%22)

This project is based on the [darcula](https://github.com/bulenkov/Darcula) look and feel for Swing.
Gradually all the custom UI and more from the darcula project wil be ported over and given a new look that follows the newer darcula look in IntelliJ.


# Screenshots
![Darcula Theme](https://github.com/weisJ/darklaf/blob/master/img/file_chooser_darcula.png) | ![IntelliJ Theme](https://github.com/weisJ/darklaf/blob/master/img/file_chooser_intellij.png)
:-------------------------:|:-------------------------:
Darcula Theme | IntelliJ Theme

![Solarized Dark Theme](https://github.com/weisJ/darklaf/blob/master/img/file_chooser_solarized_dark.png) | ![Solarized Light Theme](https://github.com/weisJ/darklaf/blob/master/img/file_chooser_solarized_light.png)
:-------------------------:|:-------------------------:
Solarized Dark Theme | Solarized Light Theme

# Usage & Features
You can either use the current build from [releases](https://github.com/weisJ/darklaf/releases) or the the [bin folder](https://github.com/weisJ/darklaf/tree/master/bin). These binaries already include a stripped down version of all dependecies.

This project is available on Maven Central:
### Maven
````xml
<dependency>
  <groupId>com.github.weisj</groupId>
  <artifactId>darklaf</artifactId>
  <version>1.3.1.6</version>
</dependency>
````
### Gradle
````
implementation 'com.github.weisj:darklaf:1.3.1.6'
````

## Installation
The LookAndFeel can be easily installed using the 'LafManager'
````java
LafManager.install(); //For default theme (IntelliJ)
LafManager.install(new DarculaTheme()); //Specify the used theme.
````
or by using the UIManager
````java
LafManager.setTheme(new DarculaTheme());
UIManager.setLookAndFeel(DarkLaf.class.getCanonicalName());
````

## Example
````java
import com.github.weisj.darklaf.LafManager;
import javax.swing.*;
import java.awt.*;

public class DarklafDemo {

    public static void main(final String[] args) {
         SwingUtilities.invokeLater(() -> {
            LafManager.install();

            JFrame frame = new JFrame("Darklaf - A Darcula LaF for Swing");
            frame.setSize(600, 400);

            JButton button = new JButton("Click here!");

            JPanel content = new JPanel();
            content.add(button);

            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(content);
            frame.setVisible(true);
        });
    }
}
````

All custom component-variants and settings are customizable by setting the appropriate client
property of the component.

//Todo: list of properties

This LookAndFeel supports custom window decorations (only Windows at this point). In contrast to most other LaFs the native window behaviour is not compromised giving a seamless experience that still looks native.

# Build
To build the project replace the ````build.gradle```` script with the one
fitting your platform i.e.
- You only have a x86 cpp installation -> ````build_x86.gradle````
- You only have a x64 cpp installation -> ````build_x64.gradle````
- You have a 86x_64x_multilib installation -> ````build.gradle````

# Contribute
Here is a list of things that currently are not finished or need refinement. This list is a work in progress and being updated regulary. If you find any problems with the LaF feel free to submit an issue:

- [Native window decorations on Linux and MacOS.](https://github.com/weisJ/darklaf/issues/2)
  * See [jniplatform/cpp](https://github.com/weisJ/darklaf/tree/master/src/jniplatform/cpp) for the windows implementation.
- [Adjustment of platform specific properties](https://github.com/weisJ/darklaf/issues/2)
  * See the [properties folder](https://github.com/weisJ/darklaf/tree/master/src/main/resources/com/github/weisj/darklaf/properties) especially the plaform folder.
  * See todo in [DarkLaf](https://github.com/weisJ/darklaf/blob/master/src/main/java/com/github/weisj/darklaf/DarkLaf.java)
- [Custom TabComponents may be visible during DnD with JTabbedPane.](https://github.com/weisJ/darklaf/issues/7)
- Right to left layout support in [DarkTitlePane](https://github.com/weisJ/darklaf/blob/master/src/main/java/com/github/weisj/darklaf/ui/rootpane/DarkTitlePane.java).
- Examine if Todo branch in [TabbedPaneUtil](https://github.com/weisJ/darklaf/blob/master/src/main/java/com/github/weisj/darklaf/ui/tabbedpane/TabbedPaneUtil.java) needs something to be done about.
- [Arrow button cycle support for JComboBox.](https://github.com/weisJ/darklaf/issues/10)
