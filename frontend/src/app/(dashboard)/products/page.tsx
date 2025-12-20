import { ProductList } from '@/components/products/product-list';
import { Button } from '@/components/ui/button';
import { Plus } from 'lucide-react';
import Link from 'next/link';

export default function ProductsPage() {
  return (
    <div className="space-y-6">
      <div className="flex items-center justify-between">
        <div>
          <h1 className="text-3xl font-bold">Sản phẩm</h1>
          <p className="text-muted-foreground">
            Quản lý danh mục sản phẩm của cửa hàng
          </p>
        </div>
        <Link href="/products/create">
          <Button>
            <Plus className="mr-2 h-4 w-4" />
            Thêm sản phẩm
          </Button>
        </Link>
      </div>
      <ProductList />
    </div>
  );
}
