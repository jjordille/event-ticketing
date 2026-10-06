// Thin wrapper around fetch. Every backend call goes through here, so
// auth headers and error handling can be added in one place later.
export async function apiGet<T>(path: string): Promise<T> {
  const response = await fetch(`/api${path}`)
  if (!response.ok) {
    throw new Error(`GET ${path} failed: ${response.status}`)
  }
  return response.json() as Promise<T>
}
