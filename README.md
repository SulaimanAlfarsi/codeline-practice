# Team Workflow Guide

This repository is now prepared for team-based practice work.

## Project Structure

- `src/` contains the shared Java project code.
- `team/` contains one folder for each team member.

Each team member should work inside their own folder for notes, exercises, drafts, screenshots, or planning files. Shared application code should still be updated in `src/` only when the team agrees on the change.

## Team Folders

- `team/formabdulmajeed/`
- `team/fromabdullahalhadabi/`
- `team/fromabdullahhosni/`
- `team/fromalharith/`
- `team/fromalharithalkindi/`
- `team/fromaljolanda/`
- `team/fromibrahim/`
- `team/fromsaif/`
- `team/fromsulaiman/`
- `team/fromyarab/`

## How Each Member Should Work

1. Pull the latest code before starting work.
2. Create or switch to your own branch. Do not work directly on `main`.
3. Do personal notes and temporary files inside your own folder under `team/`.
4. If you change shared code in `src/`, keep the change small and clear.
5. Test your change before committing.
6. Commit with a clear message that explains what you changed.
7. Push your branch to GitHub.
8. Open a pull request from your branch into `main`.
9. Merge into `main` only after review or team approval.

Example commit messages:

- `Add input validation in Main.java`
- `Update fromibrahim notes for task 1`
- `Refactor welcome output in Main.java`

## Git Rules

- Do not commit files from `.idea/`, `out/`, or `*.iml`.
- Do not edit another member's folder unless the team agreed.
- Keep unrelated changes out of the same commit.
- Pull before push if others are working in the repository.
- No one should push directly to `main`.
- Every member should push only to their own branch.
- All changes to `main` should come through a pull request.

Recommended flow:

```bash
git pull
git checkout main
git pull
git checkout -b your-branch-name
git status
git add .
git commit -m "Your clear message"
git push -u origin your-branch-name
```

Example branch names:

- `formabdulmajeed/task-1`
- `fromibrahim/fix-main-output`
- `fromsaif/add-notes`

## Branch Workflow

This project should use a branch-based workflow.

- `main` is the shared stable branch.
- Each member creates their own branch from `main`.
- Each member works only in their own branch.
- Each member pushes their branch to GitHub.
- After finishing work, the member opens a pull request to merge into `main`.
- No one should commit or push directly to `main`.

Simple workflow for each member:

```bash
git checkout main
git pull
git checkout -b your-branch-name
```

Make your changes, then:

```bash
git add .
git commit -m "Describe your change"
git push -u origin your-branch-name
```

After pushing:

1. Open GitHub.
2. Create a pull request from your branch to `main`.
3. Wait for review or team approval.
4. Merge only after approval.

## Protecting Main

The team rule should be:

- `main` is protected.
- No team member pushes directly to `main`.
- Only reviewed pull requests go into `main`.

If you use GitHub, enable branch protection on `main` so direct pushes are blocked.

## Shared Code Rules

- Put production or shared Java code in `src/`.
- Keep member-specific documents inside `team/<your-name>/`.
- If two people need the same file in `src/`, coordinate before editing it.

## Notes

- The current project is a simple Java starter in `src/Main.java`.
- The repository already includes a `.gitignore` for common IDE/build files.
