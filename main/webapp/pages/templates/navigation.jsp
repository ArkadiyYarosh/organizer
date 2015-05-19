<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="well col-lg-3">
    <ul class="nav nav-list nav-pills">
        <li class="nav-header full">Информация о пользователе</li>
        <li id="person-link" class="full">
            <a href="/user" class="menu-link" style="cursor: pointer">Личная информация</a>
        </li>
        <li class="full">Подписки</li>

        <li class="nav-header ">Запланированные дела</li>
        <li id="category-link" class="full">
            <a href="/category" style="cursor: pointer">
                Категории заметок
                <span class="badge right-span">${categoryAmount}</span>
            </a>
        </li>
        <li id="notes-link" class="full">
            <a href="/notes" class="menu-link" style="cursor: pointer">
                Заметки
                <span class="badge right-span">${notesAmount}</span>
            </a>
        </li>
        <li class="full">Напоминания</li>
    </ul>
</div>