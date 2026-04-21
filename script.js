document.addEventListener('DOMContentLoaded', () => {
  const navToggle = document.querySelector('[data-nav-toggle]');
  const navMenu = document.querySelector('[data-nav-menu]');
  const themeToggle = document.querySelector('[data-theme-toggle]');
  const root = document.documentElement;

  if (navToggle && navMenu) {
    navToggle.addEventListener('click', () => {
      const expanded = navToggle.getAttribute('aria-expanded') === 'true';
      navToggle.setAttribute('aria-expanded', String(!expanded));
      navMenu.classList.toggle('is-open');
    });
  }

  root.dataset.theme = 'light';

  function syncThemeButton() {
    if (!themeToggle) {
      return;
    }
    const isDark = root.dataset.theme === 'dark';
    themeToggle.textContent = isDark ? 'Day Mode' : 'Night Mode';
    themeToggle.setAttribute('aria-pressed', String(isDark));
  }

  syncThemeButton();

  if (themeToggle) {
    themeToggle.addEventListener('click', () => {
      const nextTheme = root.dataset.theme === 'dark' ? 'light' : 'dark';
      root.dataset.theme = nextTheme;
      syncThemeButton();
    });
  }
});
