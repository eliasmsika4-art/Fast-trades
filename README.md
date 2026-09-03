# FAST TRADE Android Project

Native Android demo project for FAST TRADE.

Included:
- Login/Register UI
- Dashboard
- Deposit interface (demo/sandbox only)
- Wallet/withdrawal demo
- Referrals
- Transaction history
- Admin dashboard demo
- Gradle Wrapper bootstrap (`gradlew`, `gradlew.bat`, `gradle/wrapper/`)
- GitHub Actions workflow that builds and uploads the debug APK

## Build locally

Linux/macOS:
```bash
chmod +x ./gradlew
./gradlew assembleDebug
```

Windows:
```bat
gradlew.bat assembleDebug
```

The first wrapper run downloads Gradle 8.7 automatically.

## GitHub Actions

Push the project to GitHub. The workflow in `.github/workflows/android.yml` builds `app-debug.apk` on pushes, pull requests, and manual workflow runs. The APK is available under the workflow run's **Artifacts** section.

## Important

This project is a demo. It does NOT transfer real money or guarantee investment returns. Before accepting public funds or connecting a live payment provider, obtain applicable Tanzanian regulatory/legal approvals, KYC/AML controls, terms and consumer disclosures, and use an approved payment/merchant account.
