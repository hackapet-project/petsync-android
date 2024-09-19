# petsync-android
Phase 1 of Hackapet android project.
# Configure your environment

- Git
- Github and Gitlab accounts
- Android Studio

## Step to Step guide

### 1. **Install Git**

Git is essential for version control. It allows you to track changes in your code, collaborate with others, and manage your code repositories.

- **Check if Git is already installed:**
Open Terminal and type:
    
    ```bash
    git --version
    ```
    
    If Git is installed, you'll see the version number. If not, follow the next steps.
    
- **Install Git:**
If Git isn’t installed, you can install it via Homebrew (a package manager for macOS). First, install Homebrew if you don’t have it:
    
    ```bash
    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
    ```
    
    Then install Git:
    
    ```bash
    brew install git
    ```
    

### 2. **Set Up GitHub and GitLab Accounts**

After installing Git, you’ll want to set up your GitHub and GitLab accounts.

Create if you don’t have a [Github](https://github.com/) and [Gitlab](https://about.gitlab.com/) account.

- **Create SSH Keys:**
Generate an SSH key if you don’t already have one. This will allow you to securely connect to GitHub and GitLab without needing to enter your password every time.
    
    ```bash
    ssh-keygen -t ed25519 -C "your_email@example.com"
    
    ```
    
    Follow the prompts to save the key in the default location.
    
- **Add SSH Key to SSH Agent:**
    
    ```bash
    eval "$(ssh-agent -s)"
    ssh-add -K ~/.ssh/id_ed25519
    
    ```
    
- **Add SSH Key to GitHub:**
Copy the SSH key to your clipboard:
    
    ```bash
    pbcopy < ~/.ssh/id_ed25519.pub
    
    ```
    
    Go to GitHub [SSH Keys](https://github.com/settings/keys) and add your key.
    
    Go to GitLab [SSH Keys](https://gitlab.com/-/user_settings/ssh_keys) and add your key.
    
- **Configure Git:**
Set up your Git user information:
    
    ```bash
    git config --global user.name "Your Name"
    git config --global user.email "your_email@example.com"
    ```
    
- **Verify Configuration:**
To check your configuration:
    
    ```bash
    git config --list
    ```

### 4. **Install Android Studio**

Android Studio is the official IDE for Android development.

- **Download Android Studio:**
Visit the [Android Studio download page](https://developer.android.com/studio) and download the latest version for macOS.
- **Install Android Studio:**
Open the downloaded file and drag Android Studio to your Applications folder.
- **Run Android Studio:**
Open Android Studio from your Applications folder. It will guide you through the initial setup, including installing the necessary SDKs, plugins, and configuring your environment.
- **Configure the Android SDK:**
Ensure the Android SDK is properly configured. Go to `Android Studio > Preferences > Appearance & Behavior > System Settings > Android SDK` and verify that the required SDKs are installed.
- **Configure the AVD Manager:**
The AVD (Android Virtual Device) Manager allows you to run Android emulators. You can create virtual devices here to test your applications.

### 5. **Additional Configuration**

- **Install Homebrew (Optional):**
Homebrew is a package manager that makes it easy to install and manage software on your Mac. You can use it to install other development tools you might need.
    
    ```bash
    /bin/bash -c "$(curl -fsSL <https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh>)"
    ```
    
- **Install Java (Required for Android Studio):**
If Android Studio requires a specific version of Java, you can install it via Homebrew:
    
    ```bash
    brew install openjdk@11
    ```
    
    Then, link it:
    
    ```bash
    sudo ln -sfn /usr/local/opt/openjdk@11/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-11.jdk
    ```
    

### 6. **Verify Everything Works**

- **GitHub/GitLab:** Try cloning a repository using SSH to ensure your SSH keys are correctly configured:
    
    ```bash
    git clone git@github.com:username/repository.git
    ```
    
- **Android Studio:** Create a new Android project and run it on an emulator.
