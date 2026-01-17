
const BASE = "http://localhost:8080/tasks";

export async function listTasks() {
  const res = await fetch(BASE);
  if (!res.ok) throw new Error("Failed to fetch tasks");
  return res.json();
}

export async function createTask(task) {
  const res = await fetch(BASE, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(task),
  });
  if (!res.ok) throw new Error("Failed to create task");
  return res.json();
}

export async function updateStatus(id, status) {
  const res = await fetch(`${BASE}/${id}/status`, {
    method: "PATCH",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ status }),
  });
  if (!res.ok) throw new Error("Failed to update status");
  return res.json();
}

export async function softDelete(id) {
  const res = await fetch(`${BASE}/${id}/delete`, { method: "PATCH" });
  if (!res.ok) throw new Error("Failed to delete task");
  return true;
}
