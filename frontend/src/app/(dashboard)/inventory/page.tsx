import { InventoryList } from '@/components/inventory/inventory-list';
import { Button } from '@/components/ui/button';
import { Plus } from 'lucide-react';

export default function InventoryPage() {
  return (
    <div className="space-y-6">
      <div className="flex items-center justify-between">
        <div>
          <h1 className="text-3xl font-bold">Kho hàng</h1>
          <p className="text-muted-foreground">
            Quản lý tồn kho và nhập hàng
          </p>
        </div>
        <Button>
          <Plus className="mr-2 h-4 w-4" />
          Nhập hàng
        </Button>
      </div>
      <InventoryList />
    </div>
  );
}
