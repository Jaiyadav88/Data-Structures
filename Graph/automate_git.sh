#!/bin/bash

echo "Enter your Git username:"
read git_username

echo "Enter your Git email:"
read git_email

git config --global user.name "$git_username"
git config --global user.email "$git_email"

echo "Press 1 to create a directory and a file in it, or 0 to add a file to GitHub"
read choice

if [ "$choice" -eq 1 ]; then
    echo "Enter the name of the directory"
    read name
    mkdir "$name"
    cd "$name" || exit
    echo "Enter the file name"
    read file
    vi "$file"
else
    echo "Enter the file name"
    read file
    vi "$file"
fi

git add .
git commit -m "Added a file $file"
git push origin main

